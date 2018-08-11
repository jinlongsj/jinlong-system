
/**
 * 判断中英文混合字符的长度
 */
function isChinese(str){
	var lst = /[u00-uFF]/;       
	return !lst.test(str);      
}
function strlen(str){
	var strlength = 0;
	for (i=0; i<str.length; i++){
		if (isChinese(str.charAt(i)) == true)
			strlength = strlength + 2;
		else
			strlength = strlength + 1;
	}
	return strlength;
}