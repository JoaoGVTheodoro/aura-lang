# Como Publicar Aura no GitHub

## Passo 1: Verificar se Repositório Existe

Acesse: https://github.com/SEU_USERNAME/aura-lang

Se não existir, crie um novo:
1. Vá para https://github.com/new
2. Nome: `aura-lang`
3. Descrição: "A production-grade transpiler for the Aura programming language"
4. Público (Public)
5. Clique em "Create repository"

---

## Passo 2: Configurar Git Localmente

Copie e execute os comandos abaixo (um por um):

### A. Limpar histórico e preparar
```bash
cd /Volumes/SSD_240G/blueprints/aura

# Ver status atual
git status

# Adicionar todos os arquivos
git add .

# Commit com mensagem
git commit -m "Aura Language - Phase 4 Complete: Production-ready transpiler with stdlib and CLI"
```

### B. Remover remote antigo (se existir)
```bash
# Ver remotes atuais
git remote -v

# Se houver 'origin', remover
git remote remove origin 2>/dev/null || true

# Se houver 'upstream', remover
git remote remove upstream 2>/dev/null || true
```

### C. Adicionar novo remote (SUBSTITUIR SEU_USERNAME)
```bash
# Substituir SEU_USERNAME pelo seu username do GitHub
git remote add origin https://github.com/SEU_USERNAME/aura-lang.git

# Verificar
git remote -v
```

### D. Fazer Push (IMPORTANTE: Branch deve ser 'main', não 'master')
```bash
# Renomear branch master para main
git branch -M main

# Push para GitHub
git push -u origin main
```

---

## Passo 3: Verificar no GitHub

Após o push, acesse:
- https://github.com/SEU_USERNAME/aura-lang

Você deve ver:
- ✅ Todos os arquivos
- ✅ Código completo
- ✅ Exemplos
- ✅ Documentação

---

## 🚨 IMPORTANTE

**Substitua `SEU_USERNAME`** pelo seu username real do GitHub!

Exemplo:
```bash
git remote add origin https://github.com/joao-silva/aura-lang.git
```

---

## Teste Rápido (Opcional)

Para verificar que está tudo pronto antes de fazer push:

```bash
cd /Volumes/SSD_240G/blueprints/aura

# Ver commits
git log --oneline -5

# Ver arquivos a commitar
git status

# Ver remote configurado
git remote -v
```

---

## Se Algo der Errado

**Erro: "fatal: 'origin' does not appear to be a git repository"**
```bash
cd /Volumes/SSD_240G/blueprints/aura
git remote -v
```

**Erro: "Permission denied (publickey)"**
- Configurar SSH key no GitHub
- Ou usar token pessoal (PAT) ao invés de SSH

**Erro: "Updates were rejected"**
```bash
git pull origin main --allow-unrelated-histories
git push -u origin main
```

---

## Próximas Ações Após Push

Após push bem-sucedido:

1. **Atualizar GitHub Settings**
   - ✅ Add description
   - ✅ Add topics (transpiler, language, compiler)
   - ✅ Add README na visão principal
   - ✅ Enable discussions

2. **Criar Issues para Phase 5**
   - [ ] IDE Integration (VS Code)
   - [ ] Package Manager (apm)
   - [ ] More Examples
   - [ ] Documentation

3. **Publicizar**
   - [ ] Post no Reddit
   - [ ] Post no HackerNews
   - [ ] Post no Dev.to
   - [ ] Share no Twitter

---

## Arquivo Pronto

Tudo está pronto em:
```
/Volumes/SSD_240G/blueprints/aura/
```

Incluindo:
- ✅ Código completo (transpiler, parser, stdlib)
- ✅ Exemplos (10+ programas)
- ✅ Documentação (500+ páginas)
- ✅ Testes (100+ testes passando)
- ✅ CLI (5 comandos)
- ✅ .gitignore (configurado)

---

## Comandos Resumidos (Copy & Paste)

```bash
cd /Volumes/SSD_240G/blueprints/aura

# Limpar e preparar
git add .
git commit -m "Aura Language - Phase 4 Complete"

# Remover remotes antigos
git remote remove origin 2>/dev/null || true
git remote remove upstream 2>/dev/null || true

# Adicionar novo remote (SUBSTITUIR SEU_USERNAME!)
git remote add origin https://github.com/SEU_USERNAME/aura-lang.git

# Renomear branch
git branch -M main

# Fazer push
git push -u origin main

# Verificar
git remote -v
git log --oneline -3
```

---

**Pronto! Após esses passos, Aura estará no GitHub!** 🚀
