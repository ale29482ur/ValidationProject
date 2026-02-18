package Process.example.ValidationProject.model;

public enum StatusPedido {

    AGUARDANDO_VALIDACAO,
    EM_ANALISE_TECNICA,
    AGUARDANDO_APROVACAO,
    APROVADO,
    CANCELADO,
    EM_REPARO,
    AGUARDANDO_PAGAMENTO,
    PAGO,
    FINALIZADO;

    public StatusPedido proximoStatus() {
        return switch (this) {
            case AGUARDANDO_VALIDACAO -> EM_ANALISE_TECNICA;
            case EM_ANALISE_TECNICA -> AGUARDANDO_APROVACAO;
            case AGUARDANDO_APROVACAO -> APROVADO; // botão avançar segue fluxo principal
            case APROVADO -> EM_REPARO;
            case EM_REPARO -> AGUARDANDO_PAGAMENTO;
            case AGUARDANDO_PAGAMENTO -> PAGO;
            case PAGO -> FINALIZADO;
            default -> throw new IllegalStateException("Não é possível avançar a partir de " + this);
        };
    }
    public StatusPedido cancelStatus(){
        if (this == FINALIZADO || this == CANCELADO){
            throw new IllegalStateException("nao foi possivel cancelar um pedido");
        }
        return CANCELADO;
    }

}