package bean;
import java.util.List;
public interface RegisterDao {
	public List<Register> getRegisters();
	public int add(Register registerbean); 
}
