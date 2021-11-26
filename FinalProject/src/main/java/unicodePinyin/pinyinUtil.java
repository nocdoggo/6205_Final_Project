package unicodePinyin;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class pinyinUtil {
	
	private StringBuffer streamBuffer = new StringBuffer();
	private List<String> list = new ArrayList<String>();
	private Properties p = new Properties();
	private boolean isSimple=false;

	public pinyinUtil() {
		init();
	}

	public void init() {
		try {
			// the look up table
			//change the directory accordingly.
			p.load(new BufferedInputStream(pinyinUtil.class
					.getResourceAsStream("/sample_dict.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] toPinyin(char c) {
		int codePointOfChar = c;
		String codepointHexStr = Integer.toHexString(codePointOfChar)
				.toUpperCase();
		String str = (String) p.get(codepointHexStr);
		return str.split(",");
	}

	/**
	 * @param str intake
	 * @param isSimple true simple，falsefull
	 * @return all combo
	 */
	public List<String> convertToPinyin(String str,boolean isSimple) {
		if (str == null || "".equals(str))
			return null;
		this.isSimple=isSimple;
		list.clear();
		streamBuffer.delete(0, streamBuffer.length());
		convert(0, str);
		return list;
	}
	
	
	/**
	 * @param str raw chinese chara
	 * @return converted combo
	 */
	public List<String> convertToPinyin(String str) {
		if (str == null || "".equals(str))
			return null;
		list.clear();
		streamBuffer.delete(0, streamBuffer.length());
		this.isSimple=true;
		convert(0, str);
		streamBuffer.delete(0, streamBuffer.length());
		this.isSimple=false;
		convert(0, str);
		return list;
	}

	private void convert(int n, String str) {
		if (n == str.length()) {

			String temp=streamBuffer.toString();
			if(!list.contains(temp)){
				list.add(streamBuffer.toString());
			}
			return;
		} else {
			char c = str.charAt(n);
			// Ensure that it is under unicode mode
			if (0x3007 == c || (0x4E00 <= c && c <= 0x9FA5)) {
				String[] arrayStrings = toPinyin(c);
				if (arrayStrings == null) {
					streamBuffer.append(c);
					convert(n + 1, str);
				} else if (arrayStrings.length == 0) {
					streamBuffer.append(c);
					convert(n + 1, str);
				} else if (arrayStrings.length == 1) {

					if(isSimple){
						// Simplified Chinese
						if(!"".equals(arrayStrings[0])){
							streamBuffer.append(arrayStrings[0].charAt(0));
						}
					}else{
						streamBuffer.append(arrayStrings[0]);
					}
					convert(n + 1, str);
				} else {
					int len;
					for (int i = 0; i < arrayStrings.length; i++) {
						len = streamBuffer.length();
						if(isSimple){
							if(!"".equals(arrayStrings[i])){
								streamBuffer.append(arrayStrings[i].charAt(0));
							}
						}else{
							streamBuffer.append(arrayStrings[i]);
						}
						convert(n + 1, str);
						streamBuffer.delete(len, streamBuffer.length());
					}
				}
			} else {

				// if shit is wrong
				streamBuffer.append(c);
				convert(n + 1, str);
			}
		}
	}
	
	public static void main(String[] args) {
		
		pinyinUtil helper=new pinyinUtil();
		
		List<String> list=helper.convertToPinyin("我是傻逼");
		System.out.println(list);
		
		//simple
		list = helper.convertToPinyin("雾",true);
		System.out.println(list);
		
		//full
		list = helper.convertToPinyin("痦",false);
		System.out.println(list);
	}

}
