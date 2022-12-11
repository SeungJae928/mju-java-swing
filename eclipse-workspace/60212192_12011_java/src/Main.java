import sms_sender.*;

interface Logger {
	void log(String msg);
}

class SMSLogger extends MsgSender implements Logger {
	public SMSLogger (String phone_num) {
		super(phone_num);
	}
	
	@Override public void log(String msg) {
		super.send(msg);
		System.out.println(send(msg));
	}
}

class AtomicPlant{
	Logger myLogger;
	public AtomicPlant(Logger logger) {
		myLogger = logger;
		// 초기화
	}
	public void checkTemparature() {
		myLogger.log("classadapter_java15_방승재");
		// 로거를 이용해서 "관리자 java39 흥길동" 처럼 출력한다.
		// 각자 자기의 ID와 이름을 보내는 거다.
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SMSLogger myLogger = new SMSLogger("01085784321");// 조세형교수 전번임
		AtomicPlant ap = new AtomicPlant(myLogger);
		ap.checkTemparature();
	}

}