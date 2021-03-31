public class Main {
	public static void main(String[] args) {
		Hello();
		Print_String("teste", 100);
	}
	public static void Hello() {
		System.out.println("Hello world");
	};



	public static void Print_String(String Teste, int times) {
		while(times > 0) {
			System.out.println(Teste);
			times--;
		}
	};
}