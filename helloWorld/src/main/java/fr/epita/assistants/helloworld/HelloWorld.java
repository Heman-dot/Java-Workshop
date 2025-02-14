package fr.epita.assistants.helloworld;

public class HelloWorld{

    public void printHelloWorld(){
        System.out.print("Hello World!");

    }
    public void printHelloWorldErr(){
        System.err.println("Hello World!");
    }
    public static void main(String[] args){
        HelloWorld hello = new HelloWorld();
        hello.printHelloWorldErr();
        hello.printHelloWorld();


    }



}