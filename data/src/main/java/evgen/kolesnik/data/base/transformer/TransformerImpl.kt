package evgen.kolesnik.data.base.transformer

import evgen.kolesnik.domain.outcome.Outcome
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

fun <InputType, OutputType> modify(
    data: Flowable<InputType>,
    transformer: Transformer<InputType, OutputType>
): Flowable<Outcome<OutputType>> = data.execute(transformer.convert)

fun <InputType, OutputType> Flowable<InputType>.execute(convert: (InputType) -> OutputType):
        Flowable<Outcome<OutputType>> =
    this.observeOn(Schedulers.io())
        .map { model -> convert(model) }
        .map { list -> Outcome.success(list) }
