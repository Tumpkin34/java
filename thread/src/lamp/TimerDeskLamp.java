package lamp;

/**
 * 전원 끄기 예약이 가능한 책상 조명
 */
public class TimerDeskLamp extends DeskLamp implements Runnable{

    final static int DELAY_MILLISECOND = 5000;

    private Thread offDelayThread; // 전원 끄기 예약 쓰레드
    private Thread previousThread; // 실행중인 주소를 저장할 변수

    // TODO - TimerDeskLamp 클래스의 나머지 코드를 구현해 주세요.
    public void offDelay() {
    	if(previousThread != null) {
    		previousThread.interrupt();//이미 실행 중인 스레드가 있는지 확인
    	}
    	offDelayThread = new Thread(this);//이 클래스의 run을 사용하고 스레드화
    	offDelayThread.start();//위에서 스레드화 한 스레드 실행
    	previousThread = offDelayThread;//실행중인 주소 저장
    }
    
    @Override
    public void run() {
//    	예약 여부 확인
    	while(true) {
    		try {
				Thread.sleep(DELAY_MILLISECOND);
			} catch (InterruptedException e) {//offDelay에서 이미 실행중인 스레드가 있으면 오류 발생시킴
				System.out.println("타이머 리셋");
				break;
			}
    		turnOff();//꺼짐
    		previousThread = null;//실행 중인 메소드가 없기에 다시 비워줌
    		break;
    	}
    }
}




