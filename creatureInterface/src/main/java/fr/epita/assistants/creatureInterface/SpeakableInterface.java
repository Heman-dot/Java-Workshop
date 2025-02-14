package fr.epita.assistants.creatureInterface;

import java.util.List;

/**
 * This interface provides communication methods for the objects of the class
 * that implements it. Classes adopting this interface instantiate objects
 * capable of communication.
 */
public interface SpeakableInterface {
    /**
     * Returns the name of the object that can speak
     */
    String getName();

    /**
     * Prints "Hello, my name is {creatureName} and I'm a {creatureClassName}."
     */
    default void hello(){
        System.out.println("Hello, my name is "+ getName()+" and I'm a "+
                this.getClass().getSimpleName()+ ".");

    };

    /**
     * Greets the contact
     * The default implementation greets the contact based on its type
     * @param contact the creature to greet
     */
    default void greet(SpeakableInterface contact) {
        String contactType = contact.getClass().getSimpleName();
        String thisType = this.getClass().getSimpleName();

        switch (thisType) {
            case "Mage" -> {
                if (contact instanceof Mage) {
                    System.out.println("I welcome you, " + contact.getName() + ".");
                } else if(contact instanceof Dragon) {
                    System.out.println("Salutations " + contact.getName() + ", keeper of Ancient treasures.");
                } else if(contact instanceof Human){
                    System.out.println("Hello " + contact.getName() + ", how are you?");
                }else if (contact instanceof Mermaid){
                    System.out.println("Salutations " + contact.getName() + ", keeper of the Seas.");

                }
            }
            case "Human" -> {
                if(contact instanceof Dragon){
                    System.out.println("Salutations " + contact.getName() + ", keeper of Ancient treasures.");

                }else if(contact instanceof Human){
                    System.out.println("Hello " + contact.getName() + ", how are you?");
                }else if(contact instanceof Mermaid){
                    System.out.println("Salutations " + contact.getName() + ", keeper of the Seas.");

                }else{
                    System.out.println("Salutations " + contact.getName() + ", keeper of Arcane secrets.");
                }
            }
            case "Dragon" -> {
                if (contact instanceof Dragon) {
                    System.out.println("Greetings Lord " + contact.getName() + ".");
                    ((Dragon) this).doSomeSparkles(); // Dragon-specific behavior
                } else if(contact instanceof Mermaid){
                    System.out.println("Salutations " + contact.getName() + ", keeper of the Seas.");

                } else if(contact instanceof Human){
                    System.out.println("Salutations " + contact.getName() + " the human.");

                }
                else {
                    System.out.println("Salutations " + contact.getName() + ", keeper of Arcane secrets.");
                }
            }
            case "Mermaid" -> {
                if (contact instanceof Mermaid) {
                    System.out.println("Dear " + contact.getName() + ", welcome.");
                } else if(contact instanceof Human) {
                    System.out.println("Salutations " + contact.getName() + " the human.");
                } else if(contact instanceof Dragon){
                    System.out.println("Salutations " + contact.getName() + ", keeper of Ancient treasures.");

                }else{
                    System.out.println("Salutations " + contact.getName() + ", keeper of Arcane secrets.");

                }
            }
        }

        // Special Cases: BaseHuman greeting Human

    }




    /**
     * Allows all speakers in the collection to say hello as explained in the hello() method
     * @param speakers the list of creatures that can speak
     */
    static void helloAll(List<SpeakableInterface> speakers) {
            // FIXME
        for(SpeakableInterface speaker : speakers){
            speaker.hello();
        }
    }
}
