package cz.jiripinkas.jba.util;

import cz.jiripinkas.jba.entity.ApptlStatus;


public class UpdateProperties {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ApptlStatus z = EntityFactory.getEntity(ApptlStatus.class);
		z.setName("SAVED");
		System.out.println(z.getCreatetime());
		System.out.println(z.getCreatetime());
		
		//statusRepository.save(z);
	}
}
