/*
 *  Copyright 2004 Blandware (http://www.blandware.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package common.util;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.Perl5Substitution;
import org.apache.oro.text.regex.Substitution;
import org.apache.oro.text.regex.Util;


/**
 * <p>Contains methods to operate with strings used in regular expressions and regular expressions themselves
 * </p>
 * <p><a href="RegExUtil.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author Sergey Zubtsovskiy <a href="mailto:sergey.zubtsovskiy@blandware.com">&lt;sergey.zubtsovskiy@blandware.com&gt;</a>
 * @version $Revision: 1.1 $ $Date: 2009/07/24 03:26:03 $
 */
public class RegExUtil {
	//~ Static fields/initializers =============================================

	//~ Methods ================================================================

    /**
     * Escapes regexp metasymbols in given string. Following are escaped:
     * \, /, ., (, ), [, ], {, }, +, -, *, ?, &, |, ^, $
     *
     * @param s the string to be escaped
     * @return escaped string
     */
	public static String escapeMetasymbols(String s) {
		StringBuffer sb = new StringBuffer();
		for ( int i = 0; i < s.length(); i++ ) {
			char c = s.charAt(i);
			switch ( c ) {
				case '\\':
					sb.append("\\\\");
					break;
				case '/':
					sb.append("\\/");
					break;
				case '.':
					sb.append("\\.");
					break;
				case '(':
					sb.append("\\(");
					break;
				case ')':
					sb.append("\\)");
					break;
				case '[':
					sb.append("\\[");
					break;
				case ']':
					sb.append("\\]");
					break;
				case '{':
					sb.append("\\{");
					break;
				case '}':
					sb.append("\\}");
					break;
				case '+':
					sb.append("\\+");
					break;
				case '-':
					sb.append("\\-");
					break;
				case '*':
					sb.append("\\*");
					break;
				case '?':
					sb.append("\\?");
					break;
				case '&':
					sb.append("\\&");
					break;
				case '|':
					sb.append("\\|");
					break;
				case '^':
					sb.append("\\^");
					break;
				case '$':
					sb.append("\\$");
					break;
				default:
					sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Replaces all occurences, which match to given regular expression, in the input by specified replacement string.
	 * @param input Input string to replace occurences in
	 * @param regEx Pattern to select substring to replace
	 * @param replacement String to replace substrings, which match given regular expression
	 * @return String with all occurences, which match given regular expression, replaced with corresponding replacement string
	 * @throws MalformedPatternException if specified regular expression is malformed
	 */
	public static String replaceAll(String input, String regEx, String replacement) throws MalformedPatternException {
        return replaceAll(input, regEx, replacement, Perl5Compiler.DEFAULT_MASK);
	}

    /**
     * Replaces all occurences, which match to given regular expression, in the input by specified replacement string.
     * @param input Input string to replace occurences in
     * @param regEx Pattern to select substring to replace
     * @param replacement String to replace substrings, which match given regular expression
     * @return String with all occurences, which match given regular expression, replaced with corresponding replacement string
     * @throws MalformedPatternException if specified regular expression is malformed
     */
    public static String replaceAll(String input, String regEx, String replacement, int options) throws MalformedPatternException {
        PatternCompiler compiler = new Perl5Compiler();
        PatternMatcher matcher = new Perl5Matcher();
        Pattern pattern = compiler.compile(regEx, options);
        Substitution substitution = new Perl5Substitution(replacement);
        return Util.substitute(matcher, pattern, substitution, input, Util.SUBSTITUTE_ALL);
    }

    /**
     * Returns whether string matches a regex.
     *
     * @param input string to check
     * @param regex regular expression
     * @return whether string matches regex
     */
    public static boolean matches(String input, String regex)
            throws MalformedPatternException {
        PatternCompiler compiler = new Perl5Compiler();
        PatternMatcher matcher = new Perl5Matcher();
        Pattern pattern = compiler.compile(regex);
        return matcher.matches(input, pattern);
    }

}
