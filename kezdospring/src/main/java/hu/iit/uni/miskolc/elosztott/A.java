package hu.iit.uni.miskolc.elosztott;

public class A {

	private B b;

	public A(B b) {
		this.b = b;
	}

	public void hello() {
		b.bello();
	}

	public void setB(B b) {
		this.b = b;
	}

}
