package software.controller;

import software.services.servicesDto;
import software.services.servicesDtoToEntity;
import software.services.servicesShortDto;
import software.entities.ServiceEntity;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("services")
@RequestScoped
public class servicesRestful {


    @EJB
    private software.entities.ServiceDao serviceDao;

    @GET
    @Path("{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") long aId) {
        servicesDto ret = new servicesDto(serviceDao.getServicesById(aId).get());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<servicesShortDto> ret = serviceDao.getAll().stream().map(servicesShortDto::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addServices(servicesDto aServices) {
        ServiceEntity ent = serviceDao.addService(servicesDtoToEntity.toEntity(aServices));
        servicesDto ret = new servicesDto(ent);
        return Response.status(201).entity(ret).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response removeServices(@PathParam("id") long aId) {
        serviceDao.remove(aId);
        return Response.status(204).build();
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response editServices(servicesDto aServices) {
        serviceDao.update(servicesDtoToEntity.toEntity(aServices));
        return Response.status(200).entity(aServices).build();
    }
}