package za.co.rdiederi;

import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers;

	public Tower() {
		observers = new ArrayList<Flyable>();
	}

	public void register(Flyable flyable) {
		if (!observers.contains(flyable)) {
			System.out.println(String.format("Tower says: %s#%s(%d) registered to weather tower.", flyable, flyable.getFlyableName(), flyable.getFlyableID()));
			observers.add(flyable);
		}
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		ArrayList<Flyable> landedCraft = new ArrayList<>();
		for (Flyable var : observers) {
			var.updateConditions();
			if (var.getCoordinates().getHeight() <= 0) {
				System.out.println(String.format("Tower says: %s#%s(%d) has been deregistered.", var, var.getFlyableName(), var.getFlyableID()));
				landedCraft.add(var);
			}
		}
		System.out.println();
		observers.removeAll(landedCraft);
	}
}