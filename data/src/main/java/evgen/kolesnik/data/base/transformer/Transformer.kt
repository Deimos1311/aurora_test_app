package evgen.kolesnik.data.base.transformer

interface Transformer<InputType, OutputType> {
    var convert : (InputType) -> OutputType
}