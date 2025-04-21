package exam01;

public class ArrayIndexOutOfException {

	public static void main(String[] args) {
		//ArrayIndexOutOfException : 주워진 배열보다 더 큰 인덱스를 호출할 경우
		String[] arr = new String[2];
		arr[0] = "data";
		arr[1] = "data";
		arr[2] = "data";// 여기서 예외 발생

	}

}
