package com.codecool.dao;

import com.codecool.model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginDAO implements LoginDAOinter {

    private Document userData;

    public LoginDAO() {
        parseXMLToDocument();
    }

    private void parseXMLToDocument() {
        try {
            File userDataXML = openFile("/src/main/resources/UserData.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            userData = documentBuilder.parse(userDataXML);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userData.getDocumentElement().normalize();
    }

    private File openFile(String filePath) {
        return new File(filePath);
    }

    @Override
    public boolean checkPassword(String login, String potentialPassword) {
        boolean isPasswordCorrect = false;
        String password;
        String currentLogin;
        String[] userTypes = {"mentor", "student", "employee", "admin"};
        for (int j = 0; j < userTypes.length || isPasswordCorrect; j++) {
            NodeList userNodes = userData.getElementsByTagName(userTypes[j]);
            for (int i = 0; i < userNodes.getLength() || isPasswordCorrect; i++) {
                Node userNode = userNodes.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) userNode;
                    currentLogin = userElement.getAttribute("login");
                    if (currentLogin.equals(login)) {
                        password = userElement.getElementsByTagName("password").item(0).getTextContent();
                        if (password.equals(potentialPassword)) {
                            isPasswordCorrect = true;
                        }
                    }
                }
            }
        }
        return isPasswordCorrect;
    }

    public List<String> getUserDataList(String login) {

        List<String> userDataList = new ArrayList<>();

                String currentLogin;
        String type;
        String name;
        String surname;
        String password;
        String[] userTypes = {"mentor", "student", "employee", "admin"};
        for (int j = 0; j < userTypes.length; j++) {
            NodeList userNodes = userData.getElementsByTagName(userTypes[j]);
            for (int i = 0; i < userNodes.getLength(); i++) {
                Node userNode = userNodes.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) userNode;
                    currentLogin = userElement.getAttribute("login");
                    if (currentLogin.equals(login)) {
                        type = userElement.getElementsByTagName("type").item(0).getTextContent();
                        name = userElement.getElementsByTagName("name").item(0).getTextContent();
                        surname = userElement.getElementsByTagName("surname").item(0).getTextContent();
                        password = userElement.getElementsByTagName("password").item(0).getTextContent();
                        Arrays.asList(type, login, name, surname, password);
                    }
                }
            }
        }
        return userDataList;
    }
}
