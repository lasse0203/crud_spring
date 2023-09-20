package com.example.tp_crud_spring.services;

import com.example.tp_crud_spring.models.ContactDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class ContactService {
    private final Map<UUID, ContactDTO> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();

        ContactDTO contact1 = ContactDTO.builder()
                .id(UUID.randomUUID())
                .firstName("doha")
                .lastName("yantour")
                .phoneNumber("0658989685")
                .build();
        ContactDTO contact2 = ContactDTO.builder()
                .id(UUID.randomUUID())
                .firstName("yassmine")
                .lastName("khadra")
                .phoneNumber("0658989687")
                .build();
        ContactDTO contact3 = ContactDTO.builder()
                .id(UUID.randomUUID())
                .firstName("amina")
                .lastName("fchkel")
                .phoneNumber("0658989689")
                .build();

        contacts.put(contact1.getId(), contact1);
        contacts.put(contact2.getId(), contact2);
        contacts.put(contact3.getId(), contact3);
    }
    public List<ContactDTO> getContacts() {
        return contacts.values().stream().toList();
    }

    public Optional<ContactDTO> getContactById(UUID id) {
        return contacts.values().stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public ContactDTO addContact(ContactDTO contactData) {
        if (contactData.getId() == null) {
            contactData.setId(UUID.randomUUID());
        }

        contacts.put(contactData.getId(), contactData);

        return contactData;
    }
}



