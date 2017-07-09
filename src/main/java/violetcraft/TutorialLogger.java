package violetcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Loggerクラスです。
 * 必ず作るべきものでもないのですが、
 * 作っておくとデバッグコンソール画面にModID入りのログを出すことができるので、
 * 要所要所で出すようにすると、不具合の解決や動作の理解に役立ちます。
 */
public class TutorialLogger {

	public static Logger logger = LogManager.getLogger("TileTutorial");

	/*
	 * 以下のメソッドはわざわざ呼び出さなくても、
	 * TutorialLogger.logger.trace(msg);等で呼び出せば事足りるものではある。
	 * 出力するログに、定型文やエラーログなどを含めて出したい場合は、以下のようなメソッドを好きにカスタマイズして、
	 * ログを出したい場所でこのクラスのメソッドを呼ぶようにすると、少し手間を省略できる。
	 */
	public static void trace(String msg) {
		TutorialLogger.logger.trace(msg);
	}

	public static void info(String msg) {
		TutorialLogger.logger.info(msg);
	}

	public static void warn(String msg) {
		TutorialLogger.logger.warn(msg);
	}

}
