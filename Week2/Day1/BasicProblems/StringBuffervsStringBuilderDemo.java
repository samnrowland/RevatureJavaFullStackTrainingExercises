
public class StringBuffervsStringBuilderDemo {

	public static void main(String[] args) {
		StringBuffer buff = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 1000; i++) {
			buff.append("Hello");
		}
		
		for (int i = 0; i < 1000; i++) {
			sb.append("Hello");
		}
		
		System.out.println("StringBuffer length: " + buff.toString().length());
		System.out.println("StringBuilder length: " + sb.toString().length());
		
		buff.delete(0, buff.length());
		sb.delete(0, sb.length());
		
		Runnable bufferTask = () -> {
			for (int i = 0; i < 1000; i++) {
				buff.append("Hello");
			}
		};
		
		Runnable builderTask = () -> {
			for (int i = 0; i < 1000; i++) {
				sb.append("Hello");
			}
		};
		
		Thread bufferThread1 = new Thread(bufferTask);
		Thread bufferThread2 = new Thread(bufferTask);
		Thread builderThread1 = new Thread(builderTask);
		Thread builderThread2 = new Thread(builderTask);
		
		bufferThread1.start();
		bufferThread2.start();
		builderThread1.start();
		builderThread2.start();
		
		try {
			bufferThread1.join();
			bufferThread2.join();
			builderThread1.join();
			builderThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("StringBuffer length after threads: " + buff.toString().length());
		System.out.println("StringBuilder length after threads: " + sb.toString().length());

	}

}
