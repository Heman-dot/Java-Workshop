package fr.epita.assistants.notifyme.notify;

public class ShellNotifier implements INotificationSender{
    private final boolean toStdErr;

    public ShellNotifier(final boolean parStdErr){
        this.toStdErr = parStdErr;
    }

    @Override
    public void notify(final String parSender, final String parReceiver,
                       final String parMessage){
        String output = "Notification from "+ parSender + " to " +
                parReceiver + " received: " + parMessage;

        if(toStdErr){
            System.err.println(output);
        }else{
            System.out.println(output);
        }
    }
}