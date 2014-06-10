package calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraCareTaker {
	
	private List<CalculadoraMemento> mementos;
	private int currentMemento;
	
	public CalculadoraCareTaker() {
		mementos = new ArrayList<CalculadoraMemento>();
		currentMemento = -1;
	}
	
	public void addMemento(CalculadoraMemento memento) {
		mementos.add(memento);
		currentMemento++;
	}
	
	public CalculadoraMemento getLastMemento() {
		CalculadoraMemento memento = null;
		if(currentMemento > 0)
			memento = mementos.get(--currentMemento);
		
		return memento;
	}
	
	public CalculadoraMemento getNextMemento() {
		CalculadoraMemento memento = null;
		if(mementos.size() > 0 && currentMemento < mementos.size() - 1) {
			memento = mementos.get(++currentMemento);
		}
		return memento;
	}
	
}
