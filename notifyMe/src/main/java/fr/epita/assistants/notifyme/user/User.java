package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;
import java.util.ArrayList;
import java.util.List;

public class User implements IMultiNotificationSender{
    private final String username;
    private final List<INotificationSender> notifiers;

    public User(final String username, final List<INotificationSender> parNotificationList){
        this.username=username;
        this.notifiers=new ArrayList<>(parNotificationList);
    }

    public User(final String username){
        this(username, new ArrayList<>());
    }

    public String getUsername(){
        return username;
    }

    public void sendNotifications(final String parReceiver, final String
            parMessage){
        for(INotificationSender notifier : notifiers){
            notifier.notify(username,parReceiver,parMessage);
        }
    }
    public void addNotifier( final INotificationSender notifier){
        notifiers.add(notifier);
    }

    public List<INotificationSender> getNotifiers(){
        return new ArrayList<>(notifiers);
    }
}