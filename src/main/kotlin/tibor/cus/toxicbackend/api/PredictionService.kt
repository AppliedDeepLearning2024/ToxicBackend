package tibor.cus.toxicbackend.api


import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tibor.cus.toxicbackend.models.Chemical
import tibor.cus.toxicbackend.models.Prediction
import tibor.cus.toxicbackend.repository.ChemicalRepository
import tibor.cus.toxicbackend.repository.InferenceModelRepository
import tibor.cus.toxicbackend.repository.PredictionRepository
import kotlin.math.max

@RestController
@RequestMapping("api/v1/prediction")
class PredictionService(
    val predictionRepository: PredictionRepository,
    val chemicalRepository: ChemicalRepository,
    val modelRepository: InferenceModelRepository,
) {
    @GetMapping("")
    fun getAllPredictions(
        @RequestParam(name = "page", required = true) page: Int,
        @RequestParam(name = "pageSize", required = true) pageSize: Int,
    ): List<Prediction> {
        val pageable = PageRequest.of(page, max( pageSize, 1))
        println(pageable)
        return predictionRepository.findAll(pageable).toList()
    }

    @PostMapping("/predict")
    fun makePrediction(request: PredictionRequest): List<Prediction> {
        var chemical = chemicalRepository.findBySmile(request.smile)
        if (chemical == null) {
            val toCreate = Chemical(null, request.smile)
            chemical = chemicalRepository.save(toCreate)
            chemicalRepository.flush()
        }
        val models = modelRepository.findAllById(request.modelIds)
        println(chemical)
        println("Making prediction for ${chemical!!.smile} for ${models.size} models")
        return listOf()
    }
}

data class PredictionRequest(
    val smile: String,
    val modelIds: List<Long>
)
