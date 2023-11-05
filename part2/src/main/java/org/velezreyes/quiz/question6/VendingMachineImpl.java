package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;;

public class VendingMachineImpl implements VendingMachine {
  private int currentAmount; 
  private Map<String, Drink> drinks;

  public VendingMachineImpl(){
    this.currentAmount= 0;
    this.drinks= new HashMap<>();
    drinks.put("ScottCola", new ScottCola());
    drinks.put("KarenTea", new KarenTea());
  }
  @Override
  public void insertQuarter(){
    currentAmount += 25;
  }
  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException{
    if (drinks.containsKey(name)){
      Drink selecteDrink= drinks.get(name);
      if (currentAmount >= selecteDrink.getCost()) {
          currentAmount -= selecteDrink.getCost();
          return selecteDrink;
      } else {
        throw new NotEnoughMoneyException();
      }
    } else {
      throw new UnknownDrinkException();
    }
  }

class ScottCola implements Drink {
  @Override
  public String getName() {
    return "ScottCola";
  }
  @Override
  public boolean isFizzy() {
    return true;
  }
  public int getCost() {
    return 75;
  }
}

class KarenTea implements Drink {
  @Override
  public String getName() {
    return "KarenTea";
  }
  @Override
  public boolean isFizzy() {
    return false;
  }
  public int getCost() {
    return 100;
  }
}
  public static VendingMachine getInstance() {
    // Fix me!
    return null;
  }
}
