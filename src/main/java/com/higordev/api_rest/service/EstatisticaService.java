package com.higordev.api_rest.service;

import com.higordev.api_rest.domain.Transacao;
import com.higordev.api_rest.dto.EstatisticaResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    private final TransacaoService service;

    public EstatisticaService(TransacaoService service) {
        this.service = service;
    }

    public EstatisticaResponse obterMetricas() {
        OffsetDateTime ultimos60Segundos = OffsetDateTime.now().minusSeconds(60);

        List<Transacao> transcoesFiltradas = service.getTransacoes().stream().
                filter(t -> t.getDataHora().isAfter(ultimos60Segundos)).toList();

        DoubleSummaryStatistics estatisticas = transcoesFiltradas.stream().mapToDouble(Transacao::getValor).summaryStatistics();

        double min = estatisticas.getCount() > 0 ? estatisticas.getMin() : 0.0;
        double max = estatisticas.getCount() > 0 ? estatisticas.getMax() : 0.0;

        return new EstatisticaResponse(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                min,
                max);
    }
}
