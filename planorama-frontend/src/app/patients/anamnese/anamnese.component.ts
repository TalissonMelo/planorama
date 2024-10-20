import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-anamnese',
  templateUrl: './anamnese.component.html',
  styleUrls: ['./anamnese.component.css'],
})
export class AnamneseComponent implements OnInit {
  perguntas: any[] = [];

  novaPergunta = {
    enunciado: '',
    tipo: 'TEXTO',
    opcoes: '',
  };

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.perguntas = [
      {
        id: '7',
        enunciado: 'Qual é o seu principal motivo para a consulta?',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '8',
        enunciado: 'Descreva os sintomas que você está sentindo:',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '9',
        enunciado: 'Quando os sintomas começaram?',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '10',
        enunciado:
          'Qual é a intensidade dos seus sintomas? (Ex: leve, moderado, severo)',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '11',
        enunciado: 'Há doenças conhecidas em sua família? Se sim, quais?',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '12',
        enunciado:
          'Como você descreveria seus hábitos alimentares? (Ex: balanceados, irregulares, etc.)',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '13',
        enunciado: 'Quantas horas você se exercita por semana?',
        tipo: 'NUMERICO',
        opcoes: [],
      },
      {
        id: '14',
        enunciado: 'Você usa tabaco?',
        tipo: 'MULTIPLA_ESCOLHA',
        opcoes: ['Sim', 'Não'],
      },
      {
        id: '15',
        enunciado: 'Você consome álcool?',
        tipo: 'MULTIPLA_ESCOLHA',
        opcoes: ['Sim', 'Não'],
      },
      {
        id: '16',
        enunciado:
          'Como você descreveria sua situação socioeconômica? (Ex: estável, instável, etc.)',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '17',
        enunciado:
          'Tem alguma coisa que possa estar mantendo você assim ou piorando sua situação?',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '18',
        enunciado:
          'Como você pensa que essas sessões podem ajudar no seu problema?',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '19',
        enunciado: 'Qual sua expectativa com este tratamento?',
        tipo: 'TEXTO',
        opcoes: [],
      },
      {
        id: '20',
        enunciado:
          'No seu entorno, você tem algum apoio emocional? (Ex: amigos, familiares, terapeuta)',
        tipo: 'MULTIPLA_ESCOLHA',
        opcoes: ['Sim', 'Não'],
      },
    ];
  }

  addPergunta(): void {
    if (this.novaPergunta.enunciado) {
      this.perguntas.push({
        id: (this.perguntas.length + 1).toString(),
        enunciado: this.novaPergunta.enunciado,
        tipo: this.novaPergunta.tipo,
        opcoes:
          this.novaPergunta.tipo === 'MULTIPLA_ESCOLHA'
            ? this.novaPergunta.opcoes.split(',').map((op) => op.trim())
            : [],
      });
      this.resetNovaPergunta();
    } else {
      alert('Por favor, preencha o enunciado da pergunta.');
    }
  }

  resetNovaPergunta(): void {
    this.novaPergunta = {
      enunciado: '',
      tipo: 'TEXTO',
      opcoes: '',
    };
  }

  deletePergunta(index: number): void {
    this.perguntas.splice(index, 1);
  }

  saveAnamnese(): void {
    console.log(this.perguntas);
    alert('Perguntas salvas com sucesso!');
  }
}
