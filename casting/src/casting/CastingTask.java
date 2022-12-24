package casting;

public class CastingTask {
//	넷플릭스
//	애니메이션, 영화, 드라마 클래스 선언
//	사용자가 선택한 영상이
//	애니메이션이라면 "자막지원"기능 사용
//	영화라면 "4D"기능 사용
//	드라마라면 "굿즈"기능 사용
	
//	각 애니메이션, 영화, 드라마의 필드의 주소를 부모클래스인 Video로 업캐스팅
	public void check(Video video) {//	사용자가 선택한 영상이 어떤영상인지 구분하고 그 영상의 기능 구현
		//부모클래스로 업캐스팅되어도 자식클래스는 자식클래스의 타입을 가지고 있기 때문에 instanceof 타입을 비교하는 연산자를 통하여 영상을 구분 
		if(video instanceof Animation) {//매개변수로 받은 필드의 주소가 애니메이션 타입인지?
			Animation ani = (Animation) video;//부모타입으로 업캐스팅된 자식클래스를 다시 자식타입으로 다운캐스팅
			ani.printSubtitle();// 다운캐스팅 되었기 때문에 숨어있던 +a인 자막기능을 다시 사용가능
		}else if(video instanceof Film) {//매개변수로 받은 필드의 주소가 애니메이션 타입인지?
			Film film = (Film) video;//부모타입으로 업캐스팅된 자식클래스를 다시 자식타입으로 다운캐스팅
			film.print4D();//다운캐스팅 되었기 때문에 숨어있던 +a인 4D기능 사용가능
		}else {//매개변수로 받은 필드의 주소가 애니메이션 타입도 영화타입도 아닌경우는 드라마 밖에 없어서 드라마일 경우 실행
			Drama drama = (Drama) video;//부모타입으로 업캐스팅된 자식클래스를 다시 자식타입으로 다운캐스팅
			drama.sellGoods();//다운캐스팅 되었기 때문에 숨어있던 +a인 굿즈기능 사용가능
		}
	}
	
	public static void main(String[] args) {
		CastingTask ct = new CastingTask();// check메소드를 사용하기 위해 CastingTask객체화
		// CastingTask안에 check메소드사용 자식필드의 주소값을 넘겨줌
		ct.check(new Animation());
		ct.check(new Film());
		ct.check(new Drama());
	}
}
