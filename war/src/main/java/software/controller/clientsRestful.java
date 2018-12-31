package software.controller;

import software.clients.clientsDto;
import software.clients.clientsDtoToEntity;
import software.clients.clientsShortDto;
import software.entities.clientsEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("clients")
public class clientsRestful {


    @EJB
    private software.entities.clientsDao clientsDao;

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

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addClients(clientsDto aClients) {
        clientsEntity ent = clientsDao.addClients(clientsDtoToEntity.toEntity(aClients));
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