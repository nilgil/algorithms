import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static int n;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		Map<String, Character> morseCodeMap = MorseCodeMapGenerator.getMorseCodeMap();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (n-- > 0) {
			String message = st.nextToken();
			sb.append(morseCodeMap.get(message));
		}
		System.out.println(sb);
	}

	static class MorseCodeMapGenerator {
		private static final String HTML_MORSE_CODE_TABLE = "<tbody>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">A</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.-</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">B</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-...</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">C</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-.-.</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">D</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-..</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">E</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">F</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">..-.</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">G</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">--.</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">H</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">....</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">I</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">..</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">J</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.---</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">K</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-.-</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">L</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.-..</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">M</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">--</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">N</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-.</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">O</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">---</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">P</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.--.</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">Q</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">--.-</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">R</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.-.</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">S</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">...</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">T</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">U</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">..-</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">V</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">...-</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">W</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.--</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">X</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-..-</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">Y</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-.--</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">Z</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">--..</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">1</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.----</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">2</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">..---</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">3</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">...--</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">4</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">....-</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">5</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.....</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">6</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-....</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">7</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">--...</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">8</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">---..</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">9</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">----.</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">0</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-----</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">,</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">--..--</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.-.-.-</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">?</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">..--..</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">:</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">---...</td>\n"
			+ "\t\t</tr>\n"
			+ "\t\t<tr>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">-....-</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">@</td>\n"
			+ "\t\t\t<td style=\"text-align: center;\">.--.-.</td>\n"
			+ "\t\t</tr>\n"
			+ "\t</tbody>";

		private static final Map<String, Character> MORSE_CODE_MAP;

		static {
			Map<String, Character> tmpMap = new HashMap<>();
			Pattern pattern = Pattern.compile("<td style=\"text-align: center;\">([^<]+)</td>");
			Matcher matcher = pattern.matcher(HTML_MORSE_CODE_TABLE);

			while (matcher.find()) {
				String character = matcher.group(1);
				if (matcher.find()) {
					String morseCode = matcher.group(1);
					tmpMap.put(morseCode, character.charAt(0));
				}
			}

			MORSE_CODE_MAP = Collections.unmodifiableMap(tmpMap);
		}

		static Map<String, Character> getMorseCodeMap() {
			return MORSE_CODE_MAP;
		}
	}
}
