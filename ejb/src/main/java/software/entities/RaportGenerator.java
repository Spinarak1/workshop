package software.entities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RaportGenerator{

    private void addTextElement (Document doc, Element parent, String name, String text){
        Element e = doc.createElement(name);
        e.appendChild(doc.createTextNode(text));
        parent.appendChild(e);
    }

    private void saveService (ServiceEntity s, Document doc, Element parent, int numberOfActivities, int cost){
        Element serviceS = doc.createElement("Services");
        parent.appendChild(serviceS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        serviceS.setAttribute("id", String.valueOf(s.getId()));
        addTextElement(doc, serviceS, "date_of_acceptance", s.getDateOfAcceptance().format(formatter));
        addTextElement(doc, serviceS, "number_of_actions", String.valueOf(numberOfActivities));
        addTextElement(doc, serviceS, "cost", String.valueOf(cost));
    }

    public void sumOfCosts (EntityManager entityManager, LocalDate endDate, String path) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ds = endDate.format(formatter);
        System.out.println(ds);
        Query query = entityManager.createQuery("SELECT k FROM ServiceEntity k WHERE endDate = '" + ds + "'");
        @SuppressWarnings("unchecked")
        List<ServiceEntity> service = query.getResultList();


        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element servicesS = doc.createElement("Services");
        doc.appendChild(servicesS);
        servicesS.setAttribute("endDate", endDate.format(formatter));

        for (ServiceEntity s : service) {
            System.out.println("id_service: " + s.getId() + "id_client: " + s.getClient().getId());
            Query actionsQuery = entityManager.createQuery("SELECT c FROM ServiceEntity c WHERE id = " + s.getId());
            @SuppressWarnings("unchecked")
            List<ActionEntity> actions = actionsQuery.getResultList();
            int sumOfCosts = 0;
            for (ActionEntity c : actions) {
                sumOfCosts += c.getAmount();
            }
            System.out.println("Sum of costs: " + sumOfCosts);
            saveService(s, doc, servicesS, actions.size(), sumOfCosts);
        }


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(path));
        transformer.transform(source, result);
    }
    public void sumCostsOfYesterday (EntityManager entityManager, String catalog) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.now().minusDays(1);
        String fileName = catalog + data.format(formatter) + ".xml";
        System.out.println(fileName);
        sumOfCosts(entityManager, data, fileName);
    }
}