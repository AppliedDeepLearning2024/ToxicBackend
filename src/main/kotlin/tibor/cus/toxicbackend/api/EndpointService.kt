package tibor.cus.toxicbackend.api

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import tibor.cus.toxicbackend.models.Chemical
import tibor.cus.toxicbackend.models.Endpoint
import tibor.cus.toxicbackend.repository.EndpointRepository
import kotlin.math.max
import kotlin.math.min

@RestController
@RequestMapping("/api/v1/endpoint")
class EndpointService(
    var endpointRepository: EndpointRepository,
) {

    @GetMapping("")
    fun getAllEndpoints(
        @RequestParam(name = "page", required = true) page: Int,
        @RequestParam(name = "pageSize", required = true) pageSize: Int,
    ): List<Endpoint> {
        val pageable = PageRequest.of(page, max( pageSize, 1))
        return endpointRepository.findAll(pageable).toList()
    }
    @PostMapping("")
    fun createEndpoint(request: EndpointRequest) : Endpoint {
        val newEndpoint = Endpoint(id = null, name = request.name)
        val createdEndpoint = endpointRepository.save(newEndpoint)
        endpointRepository.flush()
        return createdEndpoint
    }
}

data class EndpointRequest(
    val name: String
)