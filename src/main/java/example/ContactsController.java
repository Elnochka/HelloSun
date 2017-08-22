package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class ContactsController {
    @Autowired
    private ContactsRepository repository;

    @RequestMapping("/contacts/read")
    @ResponseBody
    public List<Contacts> readContact() {
        List<Contacts> list = new CopyOnWriteArrayList<Contacts>();

        Iterable<Contacts> contact = repository.findAll();
        for (Contacts customer : contact) {
            list.add(customer);
        }
        return list;

    }

//    @RequestMapping(value="/contacts")
//    @ResponseBody
//    public List<Contacts> filtrContact(@RequestParam(value="nameFilter", required=false) String nameFilter) {
//
//        List<Contacts> contact = repository.findByNameNotContaining(nameFilter);
//
//        return contact;
//    }

    @RequestMapping(value="/contacts")
    @ResponseBody
    public List<Contacts> filtrContact(@RequestParam(value="nameFilter", required=false) String nameFilter) {

        List<Contacts> list = new CopyOnWriteArrayList<Contacts>();
        boolean trueValue = true;

        Iterable<Contacts> contactN = repository.findAll();
        for (Contacts customer : contactN) {
            String customerName = customer.getName();
            trueValue = customerName.matches(nameFilter);

            if (!trueValue) {
                list.add(customer);
            }
        }

    return list;

    }
}
