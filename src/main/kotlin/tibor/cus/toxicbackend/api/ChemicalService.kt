package tibor.cus.toxicbackend.api

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import tibor.cus.toxicbackend.models.Chemical
import tibor.cus.toxicbackend.models.Endpoint
import tibor.cus.toxicbackend.repository.ChemicalRepository
import kotlin.math.max

@RestController
@RequestMapping("/api/v1/chemical/")
class ChemicalService(
    var chemicalRepository: ChemicalRepository
) {

    @GetMapping("")
    fun getAllChemical(
        @RequestParam(name = "page", required = true) page: Int,
        @RequestParam(name = "pageSize", required = true) pageSize: Int,
    ): List<Chemical> {
        val pageable = PageRequest.of(page, max( pageSize, 1))
        return chemicalRepository.findAll(pageable).toList()
    }

    @GetMapping("{smile}")
    fun getChemicalBySmile(@PathVariable("smile") smile: String): Chemical? {
        return chemicalRepository.findBySmile(smile)
    }

    @PostMapping("")
    fun createChemical(request: ChemicalRequest) : Chemical {
        val newChemical = Chemical(id = null, smile = request.smile)
        val createdEndpoint = chemicalRepository.save(newChemical)
        chemicalRepository.flush()
        return createdEndpoint
    }
}

data class ChemicalRequest(
    val smile: String
)