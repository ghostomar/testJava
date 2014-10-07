//controleur
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Types unType1 = new Types(4,"test2");
		//Types unType2 = new Types(5,"test3");
		//TypeList unTypLi = new TypeList();
		//unTypLi.AddTypes(unType1);
		//unTypLi.AddTypes(unType2);
		Model.connexionBdd();
		Model.insert(unType1);
		new Vue(Model.select()).setVisible(true);
		Model.exitBdd();
	}
}
