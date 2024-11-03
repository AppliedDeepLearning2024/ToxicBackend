package tibor.cus.toxicbackend.api

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import tibor.cus.toxicbackend.models.InferenceModel
import tibor.cus.toxicbackend.repository.InferenceModelRepository
import kotlin.math.max


@RestController
@RequestMapping("/api/v1/model")
class InferenceModelService(
    var inferenceModelRepository: InferenceModelRepository,
    ) {

    @GetMapping("")
    fun getAllInferenceModels(
        @RequestParam(name = "page", required = true) page: Int,
        @RequestParam(name = "pageSize", required = true) pageSize: Int,
    ): List<InferenceModel> {
        val pageable = PageRequest.of(page, max( pageSize, 1))
        println(pageable)
        return inferenceModelRepository.findAll(pageable).toList()
    }

    @PostMapping("")
    fun createInferenceModel(request: InferenceModelRequest): InferenceModel {
        val newModel = InferenceModel(null, request.name)
        val created = inferenceModelRepository.save(newModel)
        inferenceModelRepository.flush()
        return created
    }
}

data class InferenceModelRequest(
    val name: String
)