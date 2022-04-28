package ru.learnup.mvc.mvctest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.mvc.mvctest.entity.Client;
import ru.learnup.mvc.mvctest.repository.ClientRepository;

import java.util.List;


@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;


    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return null;
    }


    public void saveClient(Client client) {
        clientRepository.save(client);
    }


    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }







}
