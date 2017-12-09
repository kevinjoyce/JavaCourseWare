package dao;
import java.util.HashMap;
import model.IEntity;;

public interface IDao {
	void insert();
	void delete();
	void update();
	public HashMap<String, IEntity> getAllEntities(); 
	public IEntity getEntity(String Id);
}
