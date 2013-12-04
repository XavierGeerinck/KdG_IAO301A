package be.kdg.week3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class ChatClientFrame extends JFrame implements TextReceiver {
    private JLabel nameLabel;
    private JTextArea history;
    private JTextField messageField;
    private JButton sendButton;
    private JButton exitButton;
    private Chatter chatter;

    public ChatClientFrame(Chatter chatter) {
        this.chatter = chatter;
        String name = chatter.getName();
        setTitle("Chat: " + name);
        createComponents(name);
        layoutComponents();
        addListeners();
        setSize(300, 300);
        setVisible(true);
    }

    private void createComponents(String name) {
        this.nameLabel = new JLabel(name);
        this.history = new JTextArea();
        this.history.setEditable(false);
        this.messageField = new JTextField();
        this.sendButton = new JButton("send");
        this.exitButton = new JButton("exit");
    }

    private void layoutComponents() {
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.add(nameLabel);
        JScrollPane historyPane = new JScrollPane(history);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        bottomPanel.add(inputPanel, BorderLayout.NORTH);
        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        exitPanel.add(exitButton);
        bottomPanel.add(exitPanel, BorderLayout.SOUTH);
        Container contentPane = getContentPane();
        contentPane.add(namePanel, BorderLayout.NORTH);
        contentPane.add(historyPane, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void addListeners() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                try {
                    stop();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    send();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    exit();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        messageField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    send();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void exit() throws RemoteException {
        stop();
        setVisible(false);
    }

    private void send() throws RemoteException {
        String message = messageField.getText();
        chatter.send(message);
    }

    private void stop() throws RemoteException {
        chatter.unregister(chatter);
    }

    public void receive(String text) {
        String historyText = history.getText();
        history.setText(historyText + '\n' + text);
    }
}
