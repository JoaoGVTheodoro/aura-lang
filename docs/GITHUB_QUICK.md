# 🚀 PUBLICAR AURA NO GITHUB - GUIA RÁPIDO

## Opção 1: Script Automático (MAIS FÁCIL!)

```bash
cd /Volumes/SSD_240G/blueprints/aura

# Executar script (substituir joao-silva por seu USERNAME)
./push-to-github.sh joao-silva
```

**Pronto!** O script faz tudo automaticamente:
1. ✅ Adiciona arquivos
2. ✅ Cria commit
3. ✅ Remove remotes antigos
4. ✅ Adiciona novo remote
5. ✅ Renomeia branch para main
6. ✅ Faz push para GitHub

---

## Opção 2: Comandos Manuais

Se preferir fazer passo a passo:

```bash
cd /Volumes/SSD_240G/blueprints/aura

# 1. Adicionar arquivos
git add .

# 2. Commit
git commit -m "Aura Language - Phase 4 Complete"

# 3. Limpar remotes antigos
git remote remove origin 2>/dev/null || true

# 4. Adicionar novo remote (SUBSTITUIR joao-silva)
git remote add origin https://github.com/joao-silva/aura-lang.git

# 5. Renomear branch
git branch -M main

# 6. Push
git push -u origin main
```

---

## ⚠️ ANTES DE EXECUTAR!

1. **Crie o repositório no GitHub:**
   - Vá para https://github.com/new
   - Nome: `aura-lang`
   - Descrição: "A production-grade transpiler for the Aura programming language"
   - Public
   - Clique em "Create repository"

2. **Substitua `joao-silva`** pelo seu GitHub username!

3. **Configure Git credentials:**
   ```bash
   git config --global user.email "seu@email.com"
   git config --global user.name "Seu Nome"
   ```

---

## Depois de Fazer Push

✅ Aura estará online em: https://github.com/SEU_USERNAME/aura-lang

Próximas ações:
1. Atualizar README no GitHub
2. Adicionar topics (transpiler, language, compiler)
3. Criar GitHub Issues para Phase 5
4. Publicizar em Reddit, HN, Dev.to

---

## Troubleshooting

**"fatal: 'origin' does not appear to be a git repository"**
```bash
cd /Volumes/SSD_240G/blueprints/aura
git remote -v
```

**"Permission denied"**
- Gerar SSH key ou usar GitHub PAT (Personal Access Token)
- Seguir https://github.com/settings/keys

**"Updates were rejected"**
```bash
git pull origin main --allow-unrelated-histories
git push -u origin main
```

---

## ✨ RESUMO

**Maneira Mais Fácil:**
```bash
./push-to-github.sh seu_username
```

**Maneira Manual:**
Ver "Opção 2" acima

**Resultado:**
Aura no GitHub! 🎉
