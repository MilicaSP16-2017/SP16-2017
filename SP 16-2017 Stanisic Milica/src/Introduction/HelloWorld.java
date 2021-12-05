package Introduction;

public class HelloWorld {

	public static void main(String[] args) {
		// Ovo je komentar
		System.out.println("Hello, World!");
		
		// PROMENLJIVE
		int firstNumber = 4;
		double secondNumber = 4.4;
		
		double sum = firstNumber + secondNumber;
		System.out.println(sum);
		
		char c = ' ';
		String firstName = "Petar";
		String lastName = "Petrovic";
		System.out.println("Student: " + firstName + c + lastName);
		
		boolean bool = true;
		
		// USLOVI
		int a = 24;
		int b = 12;
		char operation = '*';
		
		int result = -1;
		
		if (operation == '+') {
			result = a + b;
		}
		else if (operation == '-') {
			if (a > b) {
				result = a - b;
			} else {
				result = b - a;
			}
		}
		else if (operation == '*') {
			result = a * b;
		}
		else if (operation == '/') {
			result = a / b;
		}
		else {
			System.out.println("Nedozvoljeni unos!");
		}
		
		System.out.println("Rezultat je: " + result);
		
		// PETLJE
		int f = 5;
		int sumF = 1;
		while (f > 0) {
			sumF = sumF * f;
			f--;
		}
		System.out.println("Faktorijel broja 5 je: " + sumF);
		
		// VEZBE 2
		// Zadatak 1
		f = 5;
		sumF = 1;
		int i = 1;
		do {
			sumF = sumF * i;
			i++;
		} 
		while(i <= f);
		System.out.println("Faktorijel broja 5 je: " + sumF);
		
		sumF = 1;
		for(int j = 1; j <= f; j++) {
			sumF = sumF * j;
		}
		System.out.println("Faktorijel broja 5 je: " + sumF);
		
		
		// Zadatak 2
		int brojKupaca = 5;
		int brojRadnika = 5;
		int brojRaspolozivihKasa = 3;
		
		int brojOtvorenihKasa = 0;
		if (brojKupaca < 10 && brojRadnika < 5) {
			brojOtvorenihKasa = 1;
		}
		// 10 <= brojkupaca < 25
		else if (brojKupaca >= 10 && brojKupaca < 25 && brojRaspolozivihKasa >= 2) {
			brojOtvorenihKasa = 2;
		}
		else if (brojKupaca > 25 && brojRadnika > 5 && brojRaspolozivihKasa >= 3) {
			brojOtvorenihKasa = 3;
		}
		else {
			brojOtvorenihKasa = brojRaspolozivihKasa;
		}
		System.out.println("Broj otvorenih kasa u supermarketu je: " + brojOtvorenihKasa);
	
		// Zadatak 3
		for (i = 99; i >= 10; i--) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
		
		for (i = 99; i >= 10; i = i - 2) {
			System.out.println(i);
		}
	}

}
