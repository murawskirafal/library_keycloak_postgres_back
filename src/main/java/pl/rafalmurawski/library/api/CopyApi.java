package pl.rafalmurawski.library.api;


import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import pl.rafalmurawski.library.model.AddCopyCommand;
import pl.rafalmurawski.library.model.CopyViewForAll;
import pl.rafalmurawski.library.model.CopyViewForMe;
import pl.rafalmurawski.library.service.CopyService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Claim

@Path("/copies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CopyApi {

    private final CopyService copyService;
    JsonWebToken token;


    @Inject
    public CopyApi(CopyService copyService, JsonWebToken token) {
        this.copyService = copyService;
        this.token = token;
    }


    @POST
    @RolesAllowed({"admin", "user"})
    public void addCopy(AddCopyCommand addCopyCommand) {
        copyService.addCopy(addCopyCommand);
    }

    @GET
    @RolesAllowed({"user", "admin"})
    public List<CopyViewForAll> showAllCopies() {
        return copyService.showAllCopies();
    }

    @GET
    @Path("/my")
    @RolesAllowed({"user", "admin"})
    public List<CopyViewForMe> showMyCopies() {
        return copyService.showMyCopies(token.getClaim("email").toString());
    }

    @PATCH
    @Path("/rent")
    @RolesAllowed({"admin", "user"})
    public void rentCopy(@QueryParam("isbn") String isbn) {
        System.out.println("EMAIL >>>>> " + token.getClaim("email").toString());
        copyService.rentCopy(token.getClaim("email").toString(), isbn);
    }

    @PATCH
    @Path("/return/{signature}")
    @RolesAllowed({"user", "admin"})
    public void returnCopy(@PathParam("signature") Long signature) {
        copyService.returnCopy(signature, token.getClaim("email").toString());
    }


}
