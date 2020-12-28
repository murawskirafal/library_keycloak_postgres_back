package pl.rafalmurawski.library.api;

import org.eclipse.microprofile.jwt.JsonWebToken;
import pl.rafalmurawski.library.model.BorrowingHistoryView;
import pl.rafalmurawski.library.service.BorrowingHistoryService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/borrowingHistory")
@Produces(MediaType.APPLICATION_JSON)
public class BorrowingHistoryApi {

    private BorrowingHistoryService borrowingHistoryService;
    JsonWebToken token;


    @Inject
    public BorrowingHistoryApi(BorrowingHistoryService borrowingHistoryService, JsonWebToken token) {
        this.borrowingHistoryService = borrowingHistoryService;
        this.token = token;
    }

    @GET
    @RolesAllowed({"user", "admin"})
    public List<BorrowingHistoryView> getBorrowingHistoryList() {
        return borrowingHistoryService.getBorrowingHistoryList();
    }

    @GET
    @Path("/my")
    @RolesAllowed({"admin", "user"})
    public List<BorrowingHistoryView> getMyBorrowingHistoryList() {
        return borrowingHistoryService.getMyBorrowingHistoryList(token.getClaim("email").toString());
    }
}
