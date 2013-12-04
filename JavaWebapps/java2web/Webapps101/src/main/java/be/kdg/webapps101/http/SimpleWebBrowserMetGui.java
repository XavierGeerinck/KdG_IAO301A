package be.kdg.webapps101.http;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class SimpleWebBrowserMetGui extends JFrame implements HyperlinkListener {
    private JTextField hostNameField;
    private JTextField portNumberField;
    private JTextField resourceField;
    private JButton goButton;
    private JEditorPane outputPane;
    private JTextArea rawOutputPane;

    public SimpleWebBrowserMetGui() {
        super("mijn eigen webbrowser");
        maakComponenten();
        layoutComponenten();
        voegListenersToe();
        pack();
        this.setSize(getWidth(), 400);
        setVisible(true);
    }

    private void voegListenersToe() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                go();
            }
        });
        this.outputPane.addHyperlinkListener(this);
    }

    private void go() {
        String host = hostNameField.getText();
        int port = Integer.parseInt(portNumberField.getText());
        String resource = resourceField.getText();
        String result = surf(host, port, resource);
        outputPane.setText(result);
        rawOutputPane.setText(result);
    }

    private String surf(String host, int port, String resource) {
        try {
            Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            Reader in = new InputStreamReader(clientSocket.getInputStream());

            out.println("GET " + resource + " HTTP/1.1");
            out.println("Host: " + host + ":" + port);
            out.println();

            wachtOpReply(in);
            String header = leesTotLegeLijn(in);
            System.out.println("--------------------");
            System.out.println(header);
            System.out.println("--------------------");
            String body = leesRest(in);

            clientSocket.close();
            return body;
        } catch (IOException e) {
            System.out.println(e);
            return "IOException...";
        }
    }

    private void wachtOpReply(Reader in) throws IOException {
        while(!in.ready()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

            }
        }
    }

    private String leesRest(Reader in) throws IOException {
        StringBuffer result = new StringBuffer();
        boolean stop = false;
        while (!stop) {
            if (!in.ready()) {
                stop = true;
            } else {
                int c = in.read();
                if (c == -1) {
                    stop = true;
                } else {
                    result.append((char)c);
                }
            }
        }
        return result.toString();
    }

    private String leesTotLegeLijn(Reader in) throws IOException {
        StringBuffer result = new StringBuffer();
        boolean stop = false;
        boolean stopBijVolgende = false;
        while(!stop) {
            int c = in.read();
            if (c == -1) stop = true;
            if (c == 10) continue;
            if (c == 13) {
                if (stopBijVolgende) {
                    stop = true;
                }
                stopBijVolgende = true;
            }
            if (c != 13) stopBijVolgende = false;
            if (!stop) result.append((char)c);
        }
        return result.toString();
    }

    private void layoutComponenten() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("url:"), BorderLayout.WEST);
        JPanel urlPanel = new JPanel(new FlowLayout());
        urlPanel.add(hostNameField);
        urlPanel.add(new JLabel(":"));
        urlPanel.add(portNumberField);
        urlPanel.add(resourceField);
        topPanel.add(urlPanel, BorderLayout.CENTER);
        topPanel.add(goButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);
        JPanel outputPanel = new JPanel(new GridLayout(2, 1));
        outputPanel.add(new JScrollPane(outputPane));
        outputPanel.add(new JScrollPane(rawOutputPane));
        add(outputPanel, BorderLayout.CENTER);
    }

    private void maakComponenten() {
        this.hostNameField = new JTextField("www.kdg.be", 15);
        this.portNumberField = new JTextField("80", 5);
        this.resourceField = new JTextField("/", 30);
        this.goButton = new JButton("go");
        this.outputPane = new JEditorPane();
        this.outputPane.setEditable(false);
        this.outputPane.setContentType("text/html");
        this.rawOutputPane = new JTextArea();
    }

    public static void main(String[] args) {
        new SimpleWebBrowserMetGui();
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() != HyperlinkEvent.EventType.ACTIVATED) return;
        System.out.println(e.getURL());
    }
}
