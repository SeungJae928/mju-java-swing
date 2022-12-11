interface Logger{
	void log(String message);
}

class PrintLogger extends Printer implements Logger {
	@Override public void log (String msg) {
		print(msg);
	}
}

class Printer {
	public void print(String msg) {
		System.out.println("프린터가 출력: " + msg);
	}
}

class AtomicPlant{
	Logger myLogger;
	public AtomicPlant(Logger logger) {
		myLogger = logger;
	}
	public void checkTemparature() {
		myLogger.log("66도");
	}
}
public class Main {

	public static void main(String[] args) {
		PrintLogger myLogger = new PrintLogger();
		AtomicPlant ap = new AtomicPlant(myLogger);
		ap.checkTemparature();
	}

}