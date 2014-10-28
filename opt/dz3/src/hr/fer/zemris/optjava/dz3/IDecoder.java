package hr.fer.zemris.optjava.dz3;

public interface IDecoder<T> {

	public double[] decode (T t);
	public void decode (T t,double[] d);
	
}
