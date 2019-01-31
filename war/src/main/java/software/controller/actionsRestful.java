package software.controller;

import software.actions.actionsDto;
import software.actions.actionsDtoToEntity;
import software.actions.actionsShortDto;
import software.entities.ActionDao;
import software.entities.ActionEntity;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.stream.Collectors;

@Path("actions")
@RequestScoped
public class actionsRestful {


    @EJB
    private ActionDao actionsDao;

    @GET
    @Path("{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") long aId) {
        actionsDto ret = new actionsDto(actionsDao.getActionsById(aId).get());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<actionsShortDto> ret = actionsDao.getAll()
                .stream()
                .map(actionsShortDto::new)
                .collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }
    @Path("actionsByCosts")
    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getByCosts(@Context UriInfo info) {
        int costs = Integer.valueOf(info.getQueryParameters().getFirst("costs"));
        List<actionsShortDto> ret = actionsDao.getAll()
                .stream()
                .filter(action -> action.getAmount() == costs)
                .map(actionsShortDto::new)
                .collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addActions(actionsDto aActions) {
        ActionEntity ent = actionsDao.addActions(actionsDtoToEntity.toEntity(aActions));
        actionsDto ret = new actionsDto(ent);
        return Response.status(201).entity(ret).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response removeActions(@PathParam("id") long aId) {
        actionsDao.remove(aId);
        return Response.status(204).build();
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response editActions(actionsDto aActions) {
        actionsDao.update(actionsDtoToEntity.toEntity(aActions));
        return Response.status(200).entity(aActions).build();
    }
}