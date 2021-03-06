package withexecutors;

import java.io.Serializable;
import java.util.concurrent.Callable;

public interface Computable extends Serializable, Callable<Double>  {

	public abstract Double compute();
}
