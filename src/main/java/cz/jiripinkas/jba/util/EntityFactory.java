package cz.jiripinkas.jba.util;

public class EntityFactory {

	public static <T> T getEntity(Class<T> classname)
			throws InstantiationException, IllegalAccessException {
		return classname.newInstance();
	}
}