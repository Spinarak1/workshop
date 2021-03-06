package software.controller;

import software.clients.clientsDto;
import software.clients.clientsDtoToEntity;
import software.clients.clientsShortDto;
import software.entities.ClientDao;
import software.entities.ClientEntity;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.stream.Collectors;

@Path("clients")
@RequestScoped
public class clientsRestful {


    @EJB
    private ClientDao clientsDao;

    @GET
    @Path("{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") long aId) {
        clientsDto ret = new clientsDto(clientsDao.getClientsById(aId).get());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<clientsShortDto> ret = clientsDao.getAll().stream().map(clientsShortDto::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }
    @GET
    @Path("clientsByPhoneAndName")
    @Produces("application/json; charset=UTF-8")
    public Response getActionsByCosts(@Context UriInfo info) {
        String name = info.getQueryParameters().getFirst("name");
        String phoneNumber = info.getQueryParameters().getFirst("phoneNumber");

        List<clientsDto> list = clientsDao.getAll()
                .stream()
                .filter(client -> client.getName().equals(name) && client.getPhoneNumber().equals(phoneNumber))
                .map(clientsDto::new)
                .collect(Collectors.toList());
        return Response.status(200).entity(list).build();
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addClients(clientsDto aClients) {
        ClientEntity ent = clientsDao.addClients(clientsDtoToEntity.toEntity(aClients));
        clientsDto ret = new clientsDto(ent);
        return Response.status(201).entity(ret).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response removeClients(@PathParam("id") long aId) {
        clientsDao.remove(aId);
        return Response.status(204).build();
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response editClients(clientsDto aClients) {
        clientsDao.update(clientsDtoToEntity.toEntity(aClients));
        return Response.status(200).entity(aClients).build();
    }
}