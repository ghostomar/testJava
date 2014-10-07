import java.util.ArrayList;

public class TypeList {
	private ArrayList<Types> LesTypes;
	
	public TypeList() {
		LesTypes = new ArrayList<Types>(); 
	}
	
	// Ajout Contact
	public void AddTypes(Types UnTyp){
		this.LesTypes.add(UnTyp);
	}
}
